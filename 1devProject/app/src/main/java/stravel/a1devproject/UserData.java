package stravel.a1devproject;

import java.io.Serializable;

/**
    UserData 객체를 생성 한 것.
    게시글 작성, 로드에 있어 필수적으로 필요한 요소들.
 -*/

class UserData implements Serializable {
    public String userNumber;
    public String userName;
    public String userProfileIMG;

    public UserData(String userNumber, String userProfileIMG, String userName) {
        this.userNumber = userNumber;
        this.userProfileIMG = userProfileIMG;
        this.userName = userName;
    }
}
