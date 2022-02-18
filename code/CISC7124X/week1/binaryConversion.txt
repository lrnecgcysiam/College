

     static long BinaryConversion(String binaryString){
    long answer = 0;
    long creation = 1;
    for(int i = binaryString.length()-1;i>=0;i--){
        if(binaryString.charAt(i) != '0' && binaryString.charAt(i) != '1'){
            throw new NumberFormatException();
        }
        if(binaryString.charAt(i) == '1'){
            answer += creation;
        }
        creation *= 2;
    }
    return answer;
}