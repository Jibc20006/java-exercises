package jp.gihyo.projava.tasklist;

public class RunLengthCompression {
    public void runLengthComp(){
        final var COUNTER_BASE = -1;
        var data = "abbcccbaaaabccccccccccccddd";

        var count = COUNTER_BASE;
        char prev = 0;
        var builder = new StringBuilder();

        for (var ch : data.toCharArray()){
            if (prev ==ch){
                //おなじ文字が続く時
                count++;
                if(count == 9){
                    builder.append('9');
                    count = COUNTER_BASE;
                    prev = 0;
                }
            }else{
                //
                if(count >= 0){
                    builder.append((char) ('0'+ count));
                    count = COUNTER_BASE;
                }
                builder.append(ch);
                prev = ch;
            }
        }

            //最後の文字が連続していれば数字を出力
        if (count >= 0){
            builder.append((char) ('0'+ count));
        }

        var result = builder.toString();
        System.out.println(data);
        System.out.println(result);
    }

}
