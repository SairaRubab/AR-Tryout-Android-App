package com.fyp.tryone.utility;

import com.fyp.tryone.product.ItemDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 06peng on 2015/6/24.
 */
public class ImageUrlUtils {
    static ArrayList<String> wishlistImageUri = new ArrayList<>();
    static ArrayList<String> cartListImageUri = new ArrayList<>();

    public static String[] getImageUrls() {
        String[] urls = new String[] {
                "z"
        };
        return urls;
    }

    public static String[] getOffersUrls() {
        String[] urls = new String[]{
                "https://images-na.ssl-images-amazon.com/images/I/31zxUPZRdqL._AC_UL260_SR200,260_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/31XuUHTkKhL._AC_UL260_SR200,260_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/31Y4e4wUSEL._AC_UL260_SR200,260_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/31-Fwo7WKfL._AC_UL260_SR200,260_.jpg",
                "https://www.walleva.com/image/data/Lenses/Ray-Ban%20Aviator%20RB3025%2058mm/Ray-Ban%20Aviator%20RB3025%2058mm-BL/Ray-Ban%20Aviator%20RB3025%2058mm-BL-4.jpg",
                "https://culture-kings-nz.imgix.net/products/0000001710001001_normal_0010_1024x1024.jpg?v=1511131270&bg=FFF&fit=fill&h=775&w=775"
        };
        return urls;
    }

    public static String[] getElectronicsUrls() {
        String[] urls = new String[]{
                "https://static.pexels.com/photos/204611/pexels-photo-204611-medium.jpeg",
                "https://static.pexels.com/photos/214487/pexels-photo-214487-medium.jpeg"
        };
        return urls;
    }

    public static String[] getLifeStyleUrls() {
        String[] urls = new String[]{
                "https://www.maccosmetics.ca/media/export/cms/products/640x600/mac_sku_M3LNFT_640x600_0.jpg",
                "https://www.mac-cosmetics.ru/media/export/cms/products/640x600/mac_sku_M0N904_640x600_0.jpg",
                "https://www.maccosmetics.jp/media/export/cms/products/640x600/mac_sku_M0N918_640x600_0.jpg",
                "data:image/webp;base64,UklGRggDAABXRUJQVlA4IPwCAABwIQCdASosASwBPrFYpU0kIyIhInVYGIgWCelu57VZMJy49ZzpC0TfuwNi7T6E3QqH18f31ZExjh8IRUPr4/vqyJjHD4QiofXx/fVkTGOHvIub9vmt0Kh9fH99V7q067mlkHaf79dCofXx/fJF2PY1PlVHyFJqgUMfwhFQ+vj17avieE3QqH18fxq7e4R6DLGOHwhFQ+AJ8wD/6Qaj4Z4qucMasD++rImMcPAfsKiM6o99ByQvNfWRMY4fCB7QgRcCSkJg/CEVD6+P42WutZMxdau0+hN0J+Ow+zxNtH3i3QqH18epoUa/72Fg53lWzoTdCofXx/fVkTGOHwhFQ+vj++rImMcPhCKh9fH99WRMY4fCEHAA/v8BgFyAAPdN3MKqqiUm2yjBZ8v4x235tqpZymVTyM+OE5CNmkB74bpcEEreCVOAYIGiOxi6XzCTXe/k0mB5aVtyB5soNQqrJAQO8a2rxLOkBJjVY2rXRIFulfpLh4vnZgfJUD4FP8X9xXCbUGlxH/fMsz+Nm1SBmwDXfcoc7OcTuTCb92RNY05NPnRL0gKOqeOR5JYmwzj7TvIwLImaJ0DRP2MglZsfV8I4mQ8wzVaBYfrrZ8hhgbr9IKm7yPlCe0Q7lCiDZ6xJZXcJXcQeOiIlCMBoBEV3ptdK9Aedp+nL+e59Ik+aU6tSbViK6biR7kfCist/vvIDGnL+GJZKarKoPdB3ek1Ee5vz+G+8OUBs2ufZPjGTw2CSnp6/J7CIEV0OJ0sTWLkD121IyeDM9kEV0m7Fl9kTBar02sQ3nQA9b38pmX3N82IanYqH5KDj88Kr1uRK+E08XVdRu87rzhEqiDqy5FRex8/1UPLOIOo0IdiOmZVAixWStlslQUOLrlhxXpnJDDE3/6Bcj1PTx8c90SrJIW82aZQeG/nX1xseGwPuczgAEodAOizsMtsnriauEkABVACCukeZzai3jQ7x2WeyDx+CS4e/VHPOarx6U0ZkNeG0BnNOALzwWayBbtYAAAAAAA==",
                "https://www.maccosmetics.gr/media/export/cms/products/640x600/mac_sku_S34639_640x600_0.jpg",
                "https://www.maccosmetics.nl/media/export/cms/products/640x600/mac_sku_M2LPEX_640x600_0.jpg",
        };
        return urls;
    }

    // added
    public static int getTypeCode(String typeUri) {
        String[] glasses = getOffersUrls();
        String[] lipsticks = getLifeStyleUrls();
        for(String glass : glasses) {
            if(glass.equals(typeUri))
                return ItemDetailsActivity.GLASSES_TYPE;
        }
        for(String lipstick : lipsticks) {
            if(lipstick.equals(typeUri))
                return ItemDetailsActivity.LIPSTICK_TYPE;
        }
        return -1;
    }


    // Methods for Wishlist
    public void addWishlistImageUri(String wishlistImageUri) {
        this.wishlistImageUri.add(0,wishlistImageUri);
    }

    public void removeWishlistImageUri(int position) {
        this.wishlistImageUri.remove(position);
    }

    public ArrayList<String> getWishlistImageUri(){ return this.wishlistImageUri; }

    // Methods for Cart
    public void addCartListImageUri(String wishlistImageUri) {
        this.cartListImageUri.add(0,wishlistImageUri);
    }

    public void removeCartListImageUri(int position) {
        this.cartListImageUri.remove(position);
    }

    public ArrayList<String> getCartListImageUri(){ return this.cartListImageUri; }
}
