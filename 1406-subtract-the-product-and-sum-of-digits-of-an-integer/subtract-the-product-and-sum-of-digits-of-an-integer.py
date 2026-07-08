class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        product=1
        sum=0
        while(n>0):
            num=n%10
            sum=sum+num
            product=product*num
            n=n//10
        return product-sum
     