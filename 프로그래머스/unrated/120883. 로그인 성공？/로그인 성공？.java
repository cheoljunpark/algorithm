// db 반복문을 돌면서 id와 일치하는 값이 있는지 찾는다
// 일치하는 값이 있다면 login과 wrong pw 둘 중 하나 리턴 가능
//      또 다시 반복문을 돌면서 id == db_id가 같은 값 중
//      비밀번호가 같으면 login 리턴
//      비밀번호가 다르면 wrong pw 리턴
// 일치하는 값이 없다면 fail 리턴

class Solution {
    static boolean canLogin;
    static String db_id;
    static String db_pw;
    
    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String pw = id_pw[1];
        
        for(String[] str: db){
            db_id = str[0];
            db_pw = str[1];
            
            if(id.equals(db_id)){
                canLogin = true;
                break;
            }
        }
        
        if(canLogin){
            if(pw.equals(db_pw)){
                return "login";
            }
            else{
                return "wrong pw";
            }
        }else{
            return "fail";
        }
    }
}