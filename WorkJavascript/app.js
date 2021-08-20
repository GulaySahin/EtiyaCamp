import Game from "./models/game.js"
import GameService from "./services/gameService.js"
import User from "./models/user.js"
import UserService from "./services/userService.js"
import SellService from "./services/sellService.js"

let game1=new Game(1,"PUBG",300,20)
let game2=new Game(2,"CS GO",250,12)
let game3=new Game(3,"PES",150,10)
let game4=new Game(4,"LOL",500,18)



let gameService=new GameService();
gameService.add(game1);
gameService.add(game2);
gameService.add(game3);
gameService.add(game4);

console.log(gameService.list())

gameService.remove(3)
gameService.remove(30)
console.log(gameService.list()) 

let user1=new User(1,"Gülay",25)
let user2=new User(2,"Azra",12)
let user3=new User(3,"Rüzgar",15)

let userService=new UserService();
userService.add(user1);
userService.add(user2);
userService.add(user3);

console.log(userService.list())

userService.remove(2)
userService.remove(30)

console.log(userService.list())

let sellService=new SellService();
sellService.sell(user2,game1)
sellService.sell(user3,game2)

//console.log(sellService.list())