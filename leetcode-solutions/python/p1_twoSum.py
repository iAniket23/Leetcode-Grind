class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        hashmap = {}
        for i in range(len(nums)):
            hashmap[nums[i]] = i
        for i in range(len(nums)):
            comp = target - nums[i]
            
            if comp in hashmap and hashmap[comp] != i:
                return [i, hashmap[comp]]

temp = Solution()
newL = [2,7,11,15]
print(temp.twoSum(newL,9))