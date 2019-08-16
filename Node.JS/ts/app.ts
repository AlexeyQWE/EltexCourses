var el = document.getElementById("test");

class User {
    id : number;
    fio: string;
    phone : string;

    constructor(_id : number, _fio : string, _phone : string) {
        this.id = _id;
        this.fio = _fio;
        this.phone = _phone;
    }
     toString() : string {
        return this.fio + " " + this.phone;
    }
}
    var Ivan : User = new User (1, "Ivan", "800");
    console.log(Ivan.toString());
    alert("Welcome!");