package month2104;

/**
 * 反转字符串---按照空格分割之后反向拼接输出
 */
public class Problem420409 {

    public static void main(String[] args) {
        Problem420409 p = new Problem420409();
        String string="I am a student";
        p.reverseSentence(string);
        p.leftRotateString(string, 4);

    }

    public void reverseSentence(String sentence){
        if(sentence==null)
            return;
        String[] str=sentence.split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=str.length-1;i>=0;i--){
            sb.append(str[i]+" ");
        }
        System.out.println(sb);
    }

    public void leftRotateString(String sentence,int index){
        if(sentence==null||index>sentence.length()||index<0){
            return;
        }
        String[] splitString={sentence.substring(0,index),
                sentence.substring(index,sentence.length())};
        StringBuffer resultbBuffer=new StringBuffer();
        for(String s:splitString){
            resultbBuffer.append(reverse(s));
        }
        System.out.println(reverse(resultbBuffer.toString()));}

    public String reverse(String str) {
        char[] array=str.toCharArray();
        for(int i=0;i<(array.length+1)/2;i++)
        {
            char temp=array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=temp;
        }
        return String.valueOf(array);
    }
}
