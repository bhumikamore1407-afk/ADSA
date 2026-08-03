def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    L, R = merge_sort(arr[:mid]), merge_sort(arr[mid:])
    res, i, j = [], 0, 0
    while i < len(L) and j < len(R):
        if L[i] < R[j]:
            res.append(L[i])
            i += 1
        else:
            res.append(R[j])
            j += 1
    return res + L[i:] + R[j:]


print(merge_sort([42, 43, 38, 100,10]))