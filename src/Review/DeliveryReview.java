package Review;

import User.DeliveryRunner;
import java.io.Serializable;
import java.util.ArrayList;

public class DeliveryReview extends Review implements Serializable {
    private static final long serialVersionUID = 12L;
    
    private DeliveryRunner runner;

    //  DEFAULT CONSTRUCTOR  //
    public DeliveryReview() {
    }

    //  CONSTRUCTOR FOR GETTING A SPECIFIC DELIVERY REVIEW  //
    public DeliveryReview(String id) {
        super(id);
    }
    
    //  CONSTRCUTOR FOR GETTING A LIST OF DELIVERY REVIEW FOR A SPECIFIC DELIVERY RUNNER  //
    public DeliveryReview(DeliveryRunner runner) {
        this.runner = runner;
    }
    
    //  CONSTRUCTOR FOR CREATING NEW DELIVERY REVIEW  //
    public DeliveryReview(String id, String reviewComments, String reviewDate, int reviewRating, DeliveryRunner runner) {
        super(id, reviewComments, reviewDate, reviewRating);
        this.runner = runner;
    }
    
    public DeliveryRunner getRunner() {
        return runner;
    }
    
    @Override
    public DeliveryReview getReview(boolean isVendorReview) {
        return (DeliveryReview) super.getReview(isVendorReview);
    }
    
    @Override
    public String getAverageRating() {
        ArrayList<DeliveryReview> reviewList = getDeliveryReviewList();
        double totalRating = 0;
        int totalReviews = 0;
        
        if (!reviewList.isEmpty()) {
            for (DeliveryReview review : reviewList) {
                if (review.getRunner().getId().equals(getRunner().getId())) {
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
    
    public ArrayList<DeliveryReview> getDeliveryReviewList() {
        ArrayList<Review> reviewList = super.getReviewList("Delivery Runner Reviews");
        ArrayList<DeliveryReview> deliveryReviewList = new ArrayList<>();
        
        if (!reviewList.isEmpty()) {
            for (Review review : reviewList) {
                if (review instanceof DeliveryReview deliveryReview && deliveryReview.getRunner() != null &&
                        deliveryReview.getRunner().getId() != null) {
                    if (deliveryReview.getRunner().getId().equals(getRunner().getId())) {
                       deliveryReviewList.add(deliveryReview); 
                    }  
                }
            }
        }
        return deliveryReviewList;
    }
    
    public void deleteAllReviews() {
        removeData("Delivery Runner Reviews");
    }
    
    @Override
    public Object removeDataImplementation(Object object) {
        if (object instanceof DeliveryReview review && review.getId() != null) {
            if (review.getRunner() != null && !review.getRunner().getId().equals(getRunner().getId())) {
                return review;
            }
        }
        return null;
    }
}
