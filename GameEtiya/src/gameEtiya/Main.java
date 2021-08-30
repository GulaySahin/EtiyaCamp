package gameEtiya;
import cores.MernisServiceAdapter;
import entities.Game;
import entities.Gamer;
import entities.Offer;
import entities.Selling;
import managers.GameManager;
import managers.GamerManager;
import managers.GamerScoreManager;
import managers.OfferManager;
import managers.SellingManager;

public class Main {

	public static void main(String[] args) {
		//-----------Gamer---------
		
		Gamer gamer1=new Gamer();
		gamer1.setId(1);
		gamer1.setName("Rüzgar");
		gamer1.setLastName("Azra");
        gamer1.setIdentityNumber("5456784");
        gamer1.setAgeofYear(1996);
        gamer1.setGameScore(2);
        
        Gamer gamer2=new Gamer();
        gamer2.setId(2);
        gamer2.setName("Zeus");
        gamer2.setLastName(" Bongalov");
        gamer2.setIdentityNumber("1551542315");
        gamer2.setAgeofYear(1923);
        

        GamerManager gamerManager=new GamerManager(new MernisServiceAdapter());
        gamerManager.add(gamer1);
        gamerManager.add(gamer2);    
        
        //--------------Game-------------
        
        Game game=new Game(1,"PUBG","Strategy");
        Game game1=new Game(2,"LOL","Strategy");
        
        GameManager gameManager=new GameManager();
        gameManager.add(game);
        gameManager.add(game1);
        
        //-------------Offer-----------------
        Offer offer=new Offer();
        offer.setId(1);
        offer.setName("Yaz Kampanyasý");
        offer.setUnitPrice(50);
        
        Offer offer1=new Offer(2,"Kýþa Hazýrlýk Kampanyasý",45);
        
        
        OfferManager offerManager=new OfferManager();
        offerManager.add(offer);
        offerManager.add(offer1);
        
        
        //---------------------Selling---------------
        Selling selling =new Selling();
        selling.setId(1);
        selling.setGame(game);
        selling.setGamer(gamer1);
        selling.setOffer(offer);
        
        SellingManager sellingManager=new SellingManager();
        sellingManager.add(game, gamer1, offer);
        sellingManager.add(game1, gamer2, offer1);
       
        //----------------------Game Played-Score-----------------
        GamerScoreManager gamerScoreManager=new GamerScoreManager();
        gamerScoreManager.scoreCalculate(gamer1);
        gamerScoreManager.scoreCalculate(gamer2);

        
	}

}
