export default class GameService{
    constructor() {
        this.games=[]
    }
    add(game){
        if(game.unitPrice <=0) {
            console.log("Lütfen geçerli bir fiyat giriniz")
        return
        }
        this.games.push(game)
    }
    list() {
        return this.games
    }
    remove(id) {
        let indexToRemove=-1
        for(let index=0;index< this.games.length;index ++){
            if(this.games[index].id==id){
                indexToRemove=index
            }
        }
       if(indexToRemove==-1) {
           console.log("Silinecek oyun bulunmamaktadır.")
       } 
    }
}