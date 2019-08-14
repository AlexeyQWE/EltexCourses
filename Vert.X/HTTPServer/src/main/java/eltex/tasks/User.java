package eltex.tasks;

public class User {

    private Integer id;
    private String fio;
    private String phone;

    User(Integer id, String fio, String phone) {

        this.id = id;
        this.fio = fio;
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getId() {
        return id;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }
}
