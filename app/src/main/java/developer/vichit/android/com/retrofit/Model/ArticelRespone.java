package developer.vichit.android.com.retrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticelRespone {


    @SerializedName("CODE")
    private String code;
    @SerializedName("MESSAGE")
    private String message;
    @SerializedName("DATA")
    private List<Articel> articellist;
    @SerializedName("PAGINATION")
    private Pagination pagination;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Articel> getArticellist() {
        return articellist;
    }

    public void setArticellist(List<Articel> articellist) {
        this.articellist = articellist;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }


    //Author Class
    public static class Author {
        @SerializedName("ID")
        private int id;
        @SerializedName("NAME")
        private String name;
        @SerializedName("EMAIL")
        private String email;
        @SerializedName("GENDER")
        private String gender;
        @SerializedName("TELEPHONE")
        private String telephone;
        @SerializedName("STATUS")
        private String status;
        @SerializedName("FACEBOOK_ID")
        private String facebookId;
        @SerializedName("IMAGE_URL")
        private String imageUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFacebookId() {
            return facebookId;
        }

        public void setFacebookId(String facebookId) {
            this.facebookId = facebookId;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }


    //Category Class
    public static class Category {
        @SerializedName("ID")
        private int id;
        @SerializedName("NAME")
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //Articel Class
    public static class Articel {
        @SerializedName("ID")
        private int id;
        @SerializedName("TITLE")
        private String title;
        @SerializedName("DESCRIPTION")
        private String description;
        @SerializedName("CREATED_DATE")
        private String createdDate;
        @SerializedName("AUTHOR")
        private Author author;
        @SerializedName("STATUS")
        private String status;
        @SerializedName("CATEGORY")
        private Category category;
        @SerializedName("IMAGE")
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class Pagination {
        @SerializedName("PAGE")
        private int page;
        @SerializedName("LIMIT")
        private int limit;
        @SerializedName("TOTAL_COUNT")
        private int totalCount;
        @SerializedName("TOTAL_PAGES")
        private int totalPages;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }
    }

    @Override
    public String toString() {
        return "ArticelRespone{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", articellist=" + articellist +
                ", pagination=" + pagination +
                '}';
    }
}
