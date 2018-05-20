// Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
//
// Example 1:
//
//
// Input: num = "123", target = 6
// Output: ["1+2+3", "1*2*3"] 
//
//
// Example 2:
//
//
// Input: num = "232", target = 8
// Output: ["2*3+2", "2+3*2"]
//
// Example 3:
//
//
// Input: num = "105", target = 5
// Output: ["1*0+5","10-5"]
//
// Example 4:
//
//
// Input: num = "00", target = 0
// Output: ["0+0", "0-0", "0*0"]
//
//
// Example 5:
//
//
// Input: num = "3456237490", target = 9191
// Output: []
//
//


class Solution {
    List<String> res=new ArrayList<String>();
    public List<String> addOperators(String num, int target) {
        if(num==null||num.length()==0)return res;
        opr(num,"",0,target,0,0);
      return res;  
    }
    void opr(String num, String path,int pre, int target,long sum,long cross){//
        if(pre==num.length()){
            if(sum==target)res.add(path);
            return;
        }
        for(int i=pre;i<num.length();i++){
            if(i!=pre &&num.charAt(pre)=='0')break;//as 06=6
            long cur=Long.parseLong(num.substring(pre,i+1));//number we will treat with
            if(pre==0)opr(num,path+cur,i+1,target,cur,cur);//first number
            else{
                opr(num,path+"+"+cur,i+1,target,sum+cur,cur);
                opr(num,path+"-"+cur,i+1,target,sum-cur,-cur);
                opr(num,path+"*"+cur,i+1,target,sum-cross+cur*cross,cur*cross);//cross for precur
            }
        }
        
        
    }
}
