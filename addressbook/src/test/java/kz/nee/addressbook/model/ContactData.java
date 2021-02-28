package kz.nee.addressbook.model;

public class ContactData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String home;
  private final String mobile;
  private final String email;
  private String group;

  public ContactData(String firstname, String lastname, String nickname, String home, String mobile, String email, String group) {
    this.id = 0;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.home = home;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
  }

  public ContactData(int id, String firstname, String lastname, String nickname, String home, String mobile, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.home = home;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public void setId(int id) {
    this.id = id;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", home='" + home + '\'' +
            ", mobile='" + mobile + '\'' +
            ", email='" + email + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
