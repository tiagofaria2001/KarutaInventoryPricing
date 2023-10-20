import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Card> card_list = new ArrayList<>();
        try {
            File myObj = new File("cardlist.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] split_data = data.split("·");
                if(isFavorite(data.charAt(0))){
                    card_list.add(new Card(getEdition(split_data[4]),split_data[1].replaceAll("\\s+",""),getQuality(split_data[2]),split_data[5],split_data[6],Integer.parseInt(split_data[3].replaceAll("\\s+","").substring(1)),getWishlist(split_data[0]),false));
                }else{
                    card_list.add(new Card(getEdition(split_data[4]),split_data[1].replaceAll("\\s+",""),getQuality(split_data[2]),split_data[5],split_data[6],Integer.parseInt(split_data[3].replaceAll("\\s+","").substring(1)),getWishlist(split_data[0]),true));
                }
            }
            myReader.close();
        }catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
        }

        List<Price> price_list = new ArrayList<>(); // POR A MÃO OS PREÇOS SECALHAR DEPOIS MUDAR PRA FILE

        price_list.add(new Price(Edition.ONE,Print.HIGH_PRINT,1000));
        price_list.add(new Price(Edition.ONE,Print.MID_PRINT,72.5));
        //price_list.add(new Price(Edition.ONE,Print.LOW_PRINT,0));
        //price_list.add(new Price(Edition.ONE,Print.SINGLE_PRINT,0));
        price_list.add(new Price(Edition.TWO,Print.HIGH_PRINT,700));
        price_list.add(new Price(Edition.TWO,Print.MID_PRINT,72.5));
        //price_list.add(new Price(Edition.TWO,Print.LOW_PRINT,0));
        //price_list.add(new Price(Edition.TWO,Print.SINGLE_PRINT,0));
        price_list.add(new Price(Edition.THREE,Print.HIGH_PRINT,600));
        price_list.add(new Price(Edition.THREE,Print.MID_PRINT,72.5));
        //price_list.add(new Price(Edition.THREE,Print.LOW_PRINT,0));//
        //price_list.add(new Price(Edition.THREE,Print.SINGLE_PRINT,0));
        price_list.add(new Price(Edition.FOUR,Print.HIGH_PRINT,350));
        price_list.add(new Price(Edition.FOUR,Print.MID_PRINT,62.5));
        //price_list.add(new Price(Edition.FOUR,Print.LOW_PRINT,0));
        //price_list.add(new Price(Edition.FOUR,Print.SINGLE_PRINT,0));
        price_list.add(new Price(Edition.FIVE,Print.HIGH_PRINT,90));
        price_list.add(new Price(Edition.FIVE,Print.MID_PRINT,22.5));
        //price_list.add(new Price(Edition.FIVE,Print.LOW_PRINT,0));
        //price_list.add(new Price(Edition.FIVE,Print.SINGLE_PRINT,0));
        //price_list.add(new Price(Edition.SIX,Print.HIGH_PRINT,0)); //AINDA NAO EXISTEM HIGH_PRINTS
        price_list.add(new Price(Edition.SIX,Print.MID_PRINT,12.5));
        //price_list.add(new Price(Edition.SIX,Print.LOW_PRINT,0));
        //price_list.add(new Price(Edition.SIX,Print.SINGLE_PRINT,0));

        for (Card card : card_list) { //PRICING
            double rate = getRate(card.getEdition(), getPrint(card.getPrint_number()), price_list);
            if (rate == 0) {
                card.setPrice(0);
            } else {
                card.setPrice(card.getWishlist_number() / rate);
            }
        }

        Collections.sort(card_list);

        for (Card card:card_list){
            System.out.print(card.toString(1));
        }
    }

    public static double getRate(Edition edition,Print print,List<Price> price_list){
        for (Price price : price_list) {
            if (price.getEdition() == edition && price.getPrint() == print) {
                return price.getRate();
            }
        }
        return 0;
    }

    public static Print getPrint(Integer print_number){
        if(print_number>=1000){
            return Print.HIGH_PRINT;
        }
        if(print_number>=100){
            return Print.MID_PRINT;
        }
        if(print_number>=10){
            return Print.LOW_PRINT;
        }
        return Print.SINGLE_PRINT;
    }

    public static boolean isFavorite(char icon){
        return (icon!='❤');
    }
    public static Integer getWishlist(String aux){
        aux = aux.split("♡")[1].replaceAll("\\s+","");
        return Integer.parseInt(aux);
    }
    public static Edition getEdition(String aux){
        aux = aux.replaceAll("\\s+","");
        switch (aux){
            case "◈1" ->{
                return Edition.ONE;
            }
            case "◈2" ->{
                return Edition.TWO;
            }
            case "◈3" ->{
                return Edition.THREE;
            }
            case "◈4" ->{
                return Edition.FOUR;
            }
            case "◈5" ->{
                return Edition.FIVE;
            }
            case "◈6" ->{
                return Edition.SIX;
            }
        }
        return Edition.ONE;
    }
    public static Quality getQuality(String aux){
        aux = aux.replaceAll("\\s+","");
        switch (aux){
            case "☆☆☆☆" ->{
                return Quality.ZERO;
            }
            case "★☆☆☆" ->{
                return Quality.ONE;
            }
            case "★★☆☆" ->{
                return Quality.TWO;
            }
            case "★★★☆" ->{
                return Quality.THREE;
            }
            case "★★★★" ->{
                return Quality.FOUR;
            }
        }
        return Quality.ZERO;
    }
}