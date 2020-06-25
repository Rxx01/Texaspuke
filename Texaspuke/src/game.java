import java.util.Scanner;

class puke{
    int zhi;
    String daxiao;
    String huase;
    public puke(){

    }
    public puke(String daxiao,String huase) {
        this.daxiao=daxiao;
        this.huase=huase;
        if(daxiao.equals("2")) {
            this.zhi=2;
        }else if(daxiao.equals("3")) {
            this.zhi=3;
        }else if(daxiao.equals("4")) {
            this.zhi=4;
        }else if(daxiao.equals("5")) {
            this.zhi=5;
        }else if(daxiao.equals("6")) {
            this.zhi=6;
        }else if(daxiao.equals("7")) {
            this.zhi=7;
        }else if(daxiao.equals("8")) {
            this.zhi=8;
        }else if(daxiao.equals("9")) {
            this.zhi=9;
        }else if(daxiao.equals("T")) {
            this.zhi=10;
        }else if(daxiao.equals("J")) {
            this.zhi=11;
        }else if(daxiao.equals("Q")) {
            this.zhi=12;
        }else if(daxiao.equals("K")) {
            this.zhi=13;
        }else if(daxiao.equals("A")) {
            this.zhi=14;
        }
    }
}
class pai{
    puke puke1=new puke();
    puke puke2=new puke();
    puke puke3=new puke();
    puke puke4=new puke();
    puke puke5=new puke();
    int leixing;
    int isshunzi=0;
    int istonghua=0;
    int issantiao=0;
    int duizishu=0;
    int min;
    int zhi2;
    int zhi3;
    int zhi4;
    int max;




    public pai(puke puke1,puke puke2,puke puke3,puke puke4,puke puke5) {
        this.puke1 = puke1;
        this.puke2 = puke2;
        this.puke3 = puke3;
        this.puke4 = puke4;
        this.puke5 = puke5;
    }
    public void isshunzi(){//判断是否顺子
        int a[] = new int[5];
        a[0]=this.puke1.zhi;
        a[1]=this.puke2.zhi;
        a[2]=this.puke3.zhi;
        a[3]=this.puke4.zhi;
        a[4]=this.puke5.zhi;
        int t;
        for(int i=0;i<=4;i++){
            for(int j=0;j<4-i;j++){
                if(a[j]>a[j+1]){t=a[j];a[j]=a[j+1];a[j+1]=t;}
            }
        }
        this.min=a[0];
        this.zhi2=a[1];
        this.zhi3=a[2];
        this.zhi4=a[3];
        this.max=a[4];
        for(int i=0;i<=2;i++){
            if(a[i]==a[i+1]&&a[i+1]==a[i+2]){
                this.issantiao=1;
            }
        }
        for(int i=0;i<=3;i++){
            if(a[i]==a[i+1]){
                this.duizishu++;
            }
        }
        if(a[1]==a[0]+1&&a[2]==a[1]+1&&a[3]==a[2]+1&&a[4]==a[3]+1){
            this.isshunzi=1;
        }
    }
    public void istonghua(){
        if(puke1.huase.equals(puke2.huase)&&puke2.huase.equals(puke3.huase)&&puke3.huase.equals(puke4.huase)&&puke4.huase.equals(puke5.huase)){
            istonghua=1;
        }
    }
    public void panduan(){//判断该牌的类型
        isshunzi();
        istonghua();
        leixing=7;
        if(isshunzi==1&&istonghua==1){
            leixing=1;//1类型为同花顺
        }
        if(isshunzi!=1&&istonghua==1){
            leixing=2;//2类型为同花
        }
        if(isshunzi==1&&istonghua!=1){
            leixing=3;//3类型为顺子
        }
        if(isshunzi!=1&&istonghua!=1&&issantiao==1){
            leixing=4;//4类型为三条
        }
        if(this.duizishu==2&&issantiao!=1){
            leixing=5;//5为两对
        }
        if(this.duizishu==1&&issantiao!=1){
            leixing=6;//6为一对
        }

    }


}
public class game {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        System.out.println(compare("3D 2D 8D 5D 9D","2D 5H 4C 7S 8H"));//测试能否跑起来
    }
    public static String compare(String Black, String White){
        puke blackpuke1=new puke(String.valueOf(Black.charAt(0)),String.valueOf(Black.charAt(1)));
        puke blackpuke2=new puke(String.valueOf(Black.charAt(3)),String.valueOf(Black.charAt(4)));
        puke blackpuke3=new puke(String.valueOf(Black.charAt(6)),String.valueOf(Black.charAt(7)));
        puke blackpuke4=new puke(String.valueOf(Black.charAt(9)),String.valueOf(Black.charAt(10)));
        puke blackpuke5=new puke(String.valueOf(Black.charAt(12)),String.valueOf(Black.charAt(13)));
        pai blackpai=new pai(blackpuke1,blackpuke2,blackpuke3,blackpuke4,blackpuke5);
        blackpai.panduan();
        puke whitepuke1=new puke(String.valueOf(White.charAt(0)),String.valueOf(White.charAt(1)));
        puke whitepuke2=new puke(String.valueOf(White.charAt(3)),String.valueOf(White.charAt(4)));
        puke whitepuke3=new puke(String.valueOf(White.charAt(6)),String.valueOf(White.charAt(7)));
        puke whitepuke4=new puke(String.valueOf(White.charAt(9)),String.valueOf(White.charAt(10)));
        puke whitepuke5=new puke(String.valueOf(White.charAt(12)),String.valueOf(White.charAt(13)));
        pai whitepai=new pai(whitepuke1,whitepuke2,whitepuke3,whitepuke4,whitepuke5);
        whitepai.panduan();
        int a[]=new int[5];
        int b[]=new int[5];
        a[0]=blackpai.min;
        a[1]=blackpai.zhi2;
        a[2]=blackpai.zhi3;
        a[3]=blackpai.zhi4;
        a[4]=blackpai.max;
        b[0]=whitepai.min;
        b[1]=whitepai.zhi2;
        b[2]=whitepai.zhi3;
        b[3]=whitepai.zhi4;
        b[4]=whitepai.max;
        if(blackpai.leixing<whitepai.leixing){
            return "Black wins";
        }else if(blackpai.leixing>whitepai.leixing){
            return "White wins";
        }
        else{
            if(blackpai.leixing==7){
                for(int i=4;i>=0;i--){
                    if(a[i]>b[i]){
                        return "Black wins";
                    }else if(a[i]<b[i]){
                        return "White wins";
                    }
                }
                return "Tie";
            }else if(blackpai.leixing==6){
                int x=0,y=0;
                for(int i=0;i<=3;i++){
                    if(a[i]==a[i+1]){
                        x=a[i];
                    }
                    if(b[i]==b[i+1]){
                        y=b[i];
                    }
                }
                if(x>y){
                    return "Black wins";
                }else if(x<y){
                    return "White wins";
                }else{
                    for(int i=4;i>=0;i--){
                        if(a[i]>b[i]){
                            return "Black wins";
                        }else if(a[i]<b[i]){
                            return "White wins";
                        }
                    }
                    return "Tie";
                }
            }
            else if(blackpai.leixing==5){
                int x1=0,x2=0,y1=0,y2=0,t1=0,t2=0;
                for(int i=3;i>=0;i--){
                    if(a[i]==a[i+1]){
                        x1=a[i];
                        break;
                    }
                }
                for(int i=3;i>=0;i--){
                    if(b[i]==b[i+1]){
                        y1=b[i];
                        break;
                    }
                }
                for(int i=0;i<=3;i++){
                    if(a[i]==a[i+1]){
                        x2=a[i];
                    }
                }
                for(int i=0;i<=3;i++){
                    if(b[i]==b[i+1]){
                        y2=b[i];
                    }
                }
                if(x1>y1){
                    return "Black wins";
                }else if(x1<y1){
                    return "White wins";
                }else{
                    if(x2>y2){
                        return "Black wins";
                    }else if(x2<y2){
                        return "White wins";
                    }else{
                        for(int i=4;i>=0;i--){
                            if(a[i]>b[i]){
                                return "Black wins";
                            }else if(a[i]<b[i]){
                                return "White wins";
                            }
                        }
                        return "Tie";
                    }
                }
            }
            else if(blackpai.leixing==4){
                int x=0,y=0;
                for(int i=0;i<=2;i++){
                    if(a[i]==a[i+1]&&a[i+1]==a[i+2]){
                        x=a[i];
                    }
                }
                for(int i=0;i<=2;i++){
                    if(b[i]==b[i+1]&&b[i+1]==b[i+2]){
                        y=b[i];
                    }
                }
                if(x>y){
                    return "Black wins";
                }else if(x<y){
                    return "White wins";
                }else return "Tie";
            }
            else if(blackpai.leixing==3){
                if(blackpai.max>whitepai.max){
                    return "Black wins";
                }else if(blackpai.max<whitepai.max){
                    return "White wins";
                }else return "Tie";
            }
            else if(blackpai.leixing==2){
                for(int i=4;i>=0;i--){
                    if(a[i]>b[i]){
                        return "Black wins";
                    }else if(a[i]<b[i]){
                        return "White wins";
                    }
                }
            }
            else if(blackpai.leixing==1){
                if(blackpai.max>whitepai.max){
                    return "Black wins";
                }else if(blackpai.max<whitepai.max){
                    return "White wins";
                }else return "Tie";
            }
        }

        return null;
    }
}
