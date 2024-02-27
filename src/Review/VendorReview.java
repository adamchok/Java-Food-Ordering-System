package Review;

import User.Vendor;
import java.io.Serializable;
import java.util.ArrayList;

public class VendorReview extends Review implements Serializable {
    private static final long serialVersionUID = 14L;
    
    private Vendor vendor;
    
    //  DEFAULT CONSTRUCTOR  //
    public VendorReview() {
    }
    
    //  CONSTRUCTOR FOR GETTING A SPECIFIC VENDOR REVIEW  //
    public VendorReview(String id) {
        super(id);
    }
    
    //  CONSTRCUTOR FOR GETTING A LIST OF  VENDOR REVIEW FOR A SPECIFIC VENDOR  //
    public VendorReview(Vendor vendor) {
        this.vendor = vendor;
    }
    
    //  CONSTRUCTOR FOR CREATING NEW VENDOR REVIEW  //
    public VendorReview(String id, String reviewComments, String reviewDate, int reviewRating, Vendor vendor) {
        super(id, reviewComments, reviewDate, reviewRating);
        this.vendor = vendor;
    }
    
    public Vendor getVendor() {
        return vendor;
    }
    
    @Override
    public VendorReview getReview(boolean isVendorReview) {
        return (VendorReview) super.getReview(isVendorReview);
    }
    
    @Override
    public String getAverageRating() {
        ArrayList<VendorReview> reviewList = getVendorReviewList();
        double totalRating = 0;
        int totalReviews = 0;
        
        if (!reviewList.isEmpty()) {
            for (VendorReview review : reviewList) {
                if (review.getVendor().getId().equals(getVendor().getId())) {
                    totalRating += review.getReviewRating();
                    totalReviews++;
                }
            }
        }
        if (totalRating == 0) {
            return "No Reviews";
        }
        return String.valueOf(String.format("%.1f", totalRating / totalReviews));
    }
        
    public ArrayList<VendorReview> getVendorReviewList() {
        ArrayList<Review> reviewList = super.getReviewList("Vendor Reviews");
        ArrayList<VendorReview> vendorReviewList = new ArrayList<>();
        
        if (!reviewList.isEmpty()) {
            for (Review review : reviewList) {
                if (review instanceof VendorReview vendorReview && vendorReview.getVendor() != null &&
                        vendorReview.getVendor().getId() != null) {
                    if (vendorReview.getVendor().getId().equals(getVendor().getId())) {
                        vendorReviewList.add(vendorReview);
                    }
                }
            }
        }
        return vendorReviewList;
    }
    
    @Override
    public Object removeDataImplementation(Object object) {
        if (object instanceof VendorReview review && review.getId() != null) {
            if (review.getVendor() != null && !review.getVendor().getId().equals(getVendor().getId())) {
                return review;
            }
        }
        return null;
    }
}
