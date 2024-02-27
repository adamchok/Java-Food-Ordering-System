package Review;

import FileManagement.Data;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Review extends Data implements Serializable {
    private static final long serialVersionUID = 13L;
    
    private String id, reviewComments, reviewDate;
    private int reviewRating;
    
    //  DEFAULT CONSTRUCTOR  //
    public Review() {
    }
    
    //  CONSTRUCTOR TO GET A SPECIFIC REVIEW OBJECT  //
    public Review(String id) {
        this.id = id;
    }

    //  CONSTRUCTOR TO CREATE NEW REVIEW  //
    public Review(String id, String reviewComments, String reviewDate, int reviewRating) {
        this.id = id;
        this.reviewComments = reviewComments;
        this.reviewDate = reviewDate;
        this.reviewRating = reviewRating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }
    
    public abstract String getAverageRating();
    
    public ArrayList<Review> getReviewList(String fileType) {
        ArrayList<Object> objectList = super.getObjectList(fileType);
        ArrayList<Review> reviewList = new ArrayList<>();
        
        if (!objectList.isEmpty()) {
            for (Object object : objectList) {
                if (object instanceof Review review) {
                    reviewList.add(review);
                }
            }
        }
        return reviewList;
    }
    
    public Review getReview(boolean isVendorReview) {
        String file = isVendorReview ? "Vendor Reviews" : "Delivery Runner Reviews";
        return (Review) getObject(file);
    }
    
    public boolean writeReview(boolean isVendorReview) {
        String file = isVendorReview ? "Vendor Reviews" : "Delivery Runner Reviews";
        return recordData(file);
    }
    
    @Override
    public Object getObjectImplementation(Object object) {
        if (object instanceof Review review && review.getId() != null) {
            if (review.getId().equals(getId())) {
                return review;
            }
        }
        return null;
    }
    
    @Override
    public Object updateDataImplementation(Object object) {
        return object;  // DO NOTHING
    }
}
