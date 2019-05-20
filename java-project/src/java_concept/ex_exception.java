package java_concept;

/**
 * Created by idongsu on 09/05/2019.
 */
public class ex_exception {
    static void handlingException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("호출된 메소드에서 예외가 처리 됨");
        }
    }

    public static void main(String args[]) {
        try {
            handlingException();
            throw new Exception("예외발생");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}


