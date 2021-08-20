export default class SellService {
    constructor(){
        this.sales= []
    }
    sell(user,game) {
        if(user.age < game.minAge) {
            console.log(game.minAge + "yaşından küçük olduğunuz için "+game.gameName+" oyununu alamazsınız")
        } else {
            console.log(game.gameName+" oyununu başarıyla satın aldınız.")
        }
    }
    sellList() {
        return this.sales;
    }

}