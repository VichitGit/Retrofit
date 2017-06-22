package developer.vichit.android.com.retrofit.article_respone;

import android.os.Parcel;
import android.os.Parcelable;

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
    public static class Author implements Parcelable {
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

        protected Author(Parcel in) {
            id = in.readInt();
            name = in.readString();
            email = in.readString();
            gender = in.readString();
            telephone = in.readString();
            status = in.readString();
            facebookId = in.readString();
            imageUrl = in.readString();
        }

        public static final Parcelable.Creator<Author> CREATOR = new Parcelable.Creator<Author>() {
            @Override
            public Author createFromParcel(Parcel in) {
                return new Author(in);
            }

            @Override
            public Author[] newArray(int size) {
                return new Author[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeString(email);
            dest.writeString(gender);
            dest.writeString(telephone);
            dest.writeString(status);
            dest.writeString(facebookId);
            dest.writeString(imageUrl);
        }
    }


    //Category Class
    public static class Category implements Parcelable {
        @SerializedName("ID")
        private int id;
        @SerializedName("NAME")
        private String name;

        protected Category(Parcel in) {
            id = in.readInt();
            name = in.readString();
        }

        public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
            @Override
            public Category createFromParcel(Parcel in) {
                return new Category(in);
            }

            @Override
            public Category[] newArray(int size) {
                return new Category[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
        }
    }

    //Articel Class
    public static class Articel implements Parcelable {
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

        protected Articel(Parcel in) {
            id = in.readInt();
            title = in.readString();
            description = in.readString();
            createdDate = in.readString();
            author = in.readParcelable(Author.class.getClassLoader());
            status = in.readString();
            category = in.readParcelable(Category.class.getClassLoader());
            image = in.readString();
        }

        public static final Parcelable.Creator<Articel> CREATOR = new Parcelable.Creator<Articel>() {
            @Override
            public Articel createFromParcel(Parcel in) {
                return new Articel(in);
            }

            @Override
            public Articel[] newArray(int size) {
                return new Articel[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(title);
            dest.writeString(description);
            dest.writeString(createdDate);
            dest.writeParcelable(author, flags);
            dest.writeString(status);
            dest.writeParcelable(category, flags);
            dest.writeString(image);
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
