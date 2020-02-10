class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        edges = {i : [] for i in range(numCourses)}
        degrees = [0] * numCourses
        for s, t in prerequisites:
            edges[t].append(s)
            degrees[s] += 1
        
        queue = []
        
        for i in range(numCourses):
            if degrees[i] == 0:
                queue.append(i)
        
        count = 0
        while queue:
            count += 1
            curCourse = queue.pop(0)
            for t in edges[curCourse]:
                degrees[t] -= 1
                if degrees[t] == 0:
                    queue.append(t)
        return count == numCourses
