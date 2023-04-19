package Strategy;

public class Phone {
    private Functionable handPhone;

    void setPhone(Functionable handPhone){
        this.handPhone = handPhone;
    }

    void phoneCall() {
        handPhone.makePhoneCall();
    }
    void answerPhone() {
        handPhone.answerThePhone();
    }

}
