if __name__ == '__main__':
    n = int(input("The number of elements: "))
    arr = list(map(int, input("Enter the elements of the list:").split()))
    import sys
    Max=arr[0]
    r=sys.maxsize
    for i in range(0,n):
        if arr[i]>Max:
            r=Max
            Max=arr[i]
        elif arr[i]==Max:
            continue
        elif arr[i]<Max:
            if arr[i]>r:
                r=arr[i]
            
    print(r)
