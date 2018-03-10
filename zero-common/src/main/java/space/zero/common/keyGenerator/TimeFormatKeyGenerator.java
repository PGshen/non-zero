package space.zero.common.keyGenerator;

import space.zero.common.utils.DateUtils;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;



public class TimeFormatKeyGenerator implements KeyGenerator<String>{
    protected Random random;

    public TimeFormatKeyGenerator(){
        random=new SecureRandom();
        random.setSeed((new Date()).getTime());
    }


    @Override
    public String getNext(String type) {
        // TODO Auto-generated method stub
        return type+":"+getTimeString()+getRandomNumber();
    }

    @Override
    public String getNext() {
        // TODO Auto-generated method stub
        return getTimeString()+getRandomNumber();
    }

    protected String  getTimeString(){
        return DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS");
    }

    protected String  getRandomNumber(){
        return String.format("%02d",random.nextInt(100))+String.format("%02d",random.nextInt(100));
    }
    public static void main(String[] args) {
        TimeFormatKeyGenerator ss=new TimeFormatKeyGenerator();
        for(int i =0;i<10;i++){
            System.out.println(ss.getNext());
        }
    }

}
