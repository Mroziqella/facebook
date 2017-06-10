package pl.mroziqella.facebook.model;

import java.util.List;
import java.util.Map;

public class Facebook {

    private String id;
    private Long birthday;
    private String firstname;
    private String lastname;
    private String occupation;
    private String gender;
    private City city;
    private String work;
    private List<String> friends;
    private String school;
    private String location;
    private String relationship;
    private List<Post> posts;
    private Map<String, Object> additionalProperties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facebook facebook = (Facebook) o;

        if (birthday != null ? !birthday.equals(facebook.birthday) : facebook.birthday != null) return false;
        if (firstname != null ? !firstname.equals(facebook.firstname) : facebook.firstname != null) return false;
        if (lastname != null ? !lastname.equals(facebook.lastname) : facebook.lastname != null) return false;
        if (occupation != null ? !occupation.equals(facebook.occupation) : facebook.occupation != null) return false;
        if (gender != null ? !gender.equals(facebook.gender) : facebook.gender != null) return false;
        if (city != null ? !city.equals(facebook.city) : facebook.city != null) return false;
        if (work != null ? !work.equals(facebook.work) : facebook.work != null) return false;
        if (friends != null ? !friends.equals(facebook.friends) : facebook.friends != null) return false;
        if (school != null ? !school.equals(facebook.school) : facebook.school != null) return false;
        if (location != null ? !location.equals(facebook.location) : facebook.location != null) return false;
        if (relationship != null ? !relationship.equals(facebook.relationship) : facebook.relationship != null)
            return false;
        if (posts != null ? !posts.equals(facebook.posts) : facebook.posts != null) return false;
        return additionalProperties != null ? additionalProperties.equals(facebook.additionalProperties) : facebook.additionalProperties == null;
    }

    @Override
    public int hashCode() {
        int result = birthday != null ? birthday.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (work != null ? work.hashCode() : 0);
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (relationship != null ? relationship.hashCode() : 0);
        result = 31 * result + (posts != null ? posts.hashCode() : 0);
        result = 31 * result + (additionalProperties != null ? additionalProperties.hashCode() : 0);
        return result;
    }
}
