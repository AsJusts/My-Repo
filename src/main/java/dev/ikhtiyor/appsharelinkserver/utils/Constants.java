package dev.ikhtiyor.appsharelinkserver.utils;

/**
 * Created by Ikhtiyor Khaitov
 * 16/05/21
 **/

public interface Constants {
    String DEFAULT_PAGE = "0";
    String DEFAULT_SIZE = "10";

    String SUCCESS_ADD = "Muvaffaqilatli qo'shildi";
    String SUCCESS_EDIT = "Muvaffaqilatli tahrirlandi";
    String SUCCESS_DELETE = "Muvaffaqilatli o'chirildi";
    String USER_NOT_FOUND = "Tizimda bunday foydalanuvchi topilmadi";
    String LINK_NOT_FOUND = "Tizimda bunday havola topilmadi";
    String NOT_PERMISSION = "Sizda bunday huquq yo'q";
    String SYSTEM_ERROR = "Tizimda xatolik. Iltimos qayta urinib ko'ring";

    String LOCALHOST_API = "https://caronavirus-test-uz.herokuapp.com";

    static String generateUrl(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ-0123456789-abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
}
