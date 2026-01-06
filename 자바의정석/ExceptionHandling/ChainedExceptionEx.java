package 자바의정석.ExceptionHandling;

public class ChainedExceptionEx {
    public static void main(String[] args) {
        try {
            install();
        } catch (InstallException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void install() throws InstallException{
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException se) {
            InstallException ie = new InstallException("설치 중 예외 발생");
            ie.initCause(se);
            throw ie;
        } catch (MemeoryException me) {
            InstallException ie = new InstallException("설치 중 예외 발생");
            ie.initCause(me);
            throw ie;
        }finally{
            deleteTempFiles();
        }
    }
    
    static void startInstall() throws SpaceException, MemeoryException{
        if(!enoughSpace()){
            throw new SpaceException("설치할 공간이 부족합니다.");
        }

        if(!enoughMemory()){
            throw new MemeoryException("메모리가 부족합니다.");
        }
    }

    static void copyFiles(){
        // 파일 복사 코드
    }
    static void deleteTempFiles(){
        // 임시 파일 제거
    }
    static boolean enoughSpace(){
        // 설치하는데 필요한 공간이 있는지 확인
        return false;
    }
    static boolean enoughMemory(){
        // 설치하는데 필요한 공간이 있는지 확인
        return false;
    }
}
class InstallException extends Exception{
    InstallException(String msg){
        super(msg);
    }
}
class SpaceException extends Exception{
    SpaceException(String msg){
        super(msg);
    }
}
class MemeoryException extends Exception{
    MemeoryException(String msg){
        super(msg);
    }
}