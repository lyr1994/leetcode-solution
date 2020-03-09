from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze or not start or not destination:
            return False
        if start == destination:
            return True
        
        q = deque([start])
        visited = set()
        visited.add((start[0],start[1]))
        directs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        while q:
            current = q.popleft()
            if current == destination:
                return True
            for direct in directs:
                nx = current[0] + direct[0]
                ny = current[1] + direct[1]
                while 0 <= nx < len(maze) and 0 <= ny < len(maze[0]) and maze[nx][ny] == 0:
                    nx += direct[0]
                    ny += direct[1]
                nx -= direct[0]
                ny -= direct[1]
                if (nx, ny) not in visited:
                    q.append([nx, ny])
                    visited.add((nx, ny))
        return False

# Time complexity : O(mn). Complete traversal of maze will be done in the worst case. Here, mm and nn refers to the number of rows and coloumns of the maze.
# Space complexity : O(mn). visitedvisited array of size m*nm∗n is used.
