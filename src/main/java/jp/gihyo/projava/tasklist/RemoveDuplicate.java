package jp.gihyo.projava.tasklist;

public class RemoveDuplicate {

    public String remove(){

        var data = "abcccccdccc";
        char prev = 0;
        var builder = new StringBuilder();
       // for (int i=0; i<data.length();i++){
        for(char ch : data.toCharArray()){

           // char ch = data.charAt(i);
            //if(i>0 && ch == data.charAt(i -1)){

            if(ch==prev){
                continue;
            }
            builder.append(ch);
            prev = ch;


        }

        var result = builder.toString();
        System.out.println(data);

        return result;
//        System.out.println(result);
    }
}
