class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        wanted_nums = {}
        for i in range(len(nums)):
            if nums[i] in wanted_nums:
                return [wanted_nums[nums[i]], i]
            else:
                wanted_nums[target - nums[i]] = i
        
