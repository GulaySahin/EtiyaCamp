export default class User {
    constructor(id,userName,age){
        if(!id || !userName || !age) {
            console.log("Lütfen kullanıcı bilgilerini eksiksiz giriniz")
        }
   
    this.id=id;
    this.userName=userName;
    this.age=age;
}
 }