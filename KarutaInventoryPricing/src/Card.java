public class Card implements Comparable<Card>{
    private Edition edition;
    private String code;
    private Quality quality;
    private String character;
    private String serie;
    private Integer print_number;
    private Integer wishlist_number;
    private boolean fav;
    private double price;

    public Card(Edition edition, String code, Quality quality, String character, String serie, Integer print_number,Integer wishlist_number, boolean fav) {
        this.edition = edition;
        this.code = code;
        this.quality = quality;
        this.character = character;
        this.serie = serie;
        this.print_number = print_number;
        this.fav = fav;
        this.wishlist_number=wishlist_number;
        this.price = 0;
    }

    public Integer getWishlist_number() {
        return wishlist_number;
    }

    public void setWishlist_number(Integer wishlist_number) {
        this.wishlist_number = wishlist_number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getPrint_number() {
        return print_number;
    }

    public void setPrint_number(Integer print_number) {
        this.print_number = print_number;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public String toString(int b) {
        String aux;
        String aux2;
        if(price==0){
            aux2 = "-> LOOKING FOR OFFERS";
        }else{
            if(price<1)return "";
            aux2=" -> "+String.format("%.02f", price)+" :tickets:";
        }
        aux = "**♡"+wishlist_number+"** · "+code+" · "+quality+" · #"+print_number+" · "+edition+" · "+serie+" · **"+character+"** "+aux2;
        return aux+"\n";
    }

    @Override
    public String toString() {
        String aux;
        String aux2;
        if(price==0){
            aux2 = "LOOK FOR OFFERS";
        }else{
            aux2=" -> :tickets:"+String.format("%.02f", price);;
        }
        if(fav){
            aux = "❤"+" · "+"♡"+wishlist_number+" · "+code+" · "+quality+" · #"+print_number+" · "+edition+" · "+serie+" · "+character+" · "+aux2;
        }else{
            aux = "♡"+wishlist_number+" · "+code+" · "+quality+" · #"+print_number+" · "+edition+" · "+serie+" · "+character+" · "+aux2;
        }
        return aux;
    }

    @Override
    public int compareTo(Card o) {
        return Double.compare(o.getPrice(),this.price);
    }
}
