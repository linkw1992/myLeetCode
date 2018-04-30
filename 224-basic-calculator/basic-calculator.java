// Implement a basic calculator to evaluate a simple expression string.
//
// The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces  .
//
// You may assume that the given expression is always valid.
//
// Some examples:
//
// "1 + 1" = 2
// " 2-1 + 2 " = 3
// "(1+(4+5+2)-3)+(6+8)" = 23
//
//
//
//
// Note: Do not use the eval built-in library function.
//


class Solution {
    public int calculate(String s) {
                int  len=s.length(),sign=1,res=0;
                Stack<Integer>  stack=new  Stack<Integer>();
                for(int  i=0;i<len;i++){
                        if(Character.isDigit(s.charAt(i))){
                                int  sum=s.charAt(i)-'0';
                                while(i+1<len  &&  Character.isDigit(s.charAt(i+1))){
                                        sum=sum*10+s.charAt(i+1)-'0';
                                        i++;
                                }
                                res+=sum*sign;}
                                else  if(s.charAt(i)=='+'){
                                    sign=1;
                                }
                            else  if(s.charAt(i)=='-'){
                                    sign=-1;
                                }
                    else if(s.charAt(i)=='('){
                        stack.push(res);
                        stack.push(sign);//因为stack是先进后出所以符号要在后面
                        res=0;
                        sign=1;//两个指标复位
                    }
                    else if(s.charAt(i)==')'){
                        res=stack.pop()*res+stack.pop();
                    }
                        }
        return  res; 
                }
                      
    }
