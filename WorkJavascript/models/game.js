export default class Game {
    constructor(id, gameName, unitPrice, minAge) {
        if (!id || !gameName || !unitPrice || !minAge) {
            console.log("Lütfen oyun bilgilerini eksiksiz girin.")
        }
        this.id = id;
        this.gameName = gameName;
        this.unitPrice = unitPrice;
        this.minAge = minAge;

    }
}
