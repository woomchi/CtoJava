class Node:
    def __init__(self, elem, link=None):    # default 설정
        self.data = elem
        self.link = link
class Queue:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0
    def append(self, elem):
        node = Node(elem)
        if self.tail is None:
            self.head = node
        else:
            self.tail.link = node
        self.tail = node
        self.size += 1
    def pop(self):
        node = self.head
        if node is None:
            return -1
        self.head = node.link
        if node.link is None:   #요소가 한 개인가?
            self.tail = None
        self.size -= 1
        return node.data
import sys
    
def bfs(i,j):
    q = Queue()
    q.append([i,j])
    while(q.size != 0 ):
        y, x = q.pop()
        for p in range(4):
            mx = x + movex[p]
            my = y + movey[p]
            if 0 <= mx <n and 0 <= my < m:
                if arr[my][mx] == 1:
                    arr[my][mx] = 0
                    q.append([my,mx])
input = sys.stdin.readline
t = int(input())
answer = []
for _ in range(t):
    n,m,k = map(int, input().split())
    arr = [[0]*n for _ in range(m)]
    for i in range(k):
        x, y = map(int, input().split())
        arr[y][x] = 1


    count = 0
    movex = (0,0,1,-1)
    movey = (1,-1,0,0)
    for i in range(m):
        for j in range(n):
            if arr[i][j] == 1:
                count += 1
                arr[i][j] = 0
                bfs(i,j)
    print(count)