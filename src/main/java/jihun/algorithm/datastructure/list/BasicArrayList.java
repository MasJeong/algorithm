package jihun.algorithm.datastructure.list;

import java.util.Arrays;

public class BasicArrayList<E> implements BasicList<E> {

    private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기
    private static final Object[] EMPTY_ARRAY = {};	// 빈 배열

    private int size;	// 요소 개수

    Object[] array;	// 요소를 담을 배열

    // 초기 공간 할당 X
    public BasicArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    // 초기 공간 할당 O
    public BasicArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = capacity;
    }

    /**
     * 마지막 위치에 요소 추가
     * @param value 리스트에 추가할 요소
     * @return 삽입 성공여부
     */
    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        if (size == array.length) {
            resize();
        }

        array[size++] = value;
    }

    @Override
    public void add(int index, E value) {
        if (index > size || index < -1) {
            throw new IndexOutOfBoundsException("인덱스가 0보다 작거나 배열 길이보다 큽니다. ");
        }

        // 추가 시 배열길이보다 크다면 용량 증가
        if (size == array.length) {
            resize();
        }

        // 이미 데이터가 있는 경우 1칸씩 뒤로 미루기
        if (array[index] != null) {
            for (int i = index; i < size; i++) {
                // TODO 작업중
            }
        }


    }

    // addLast 메소드 구현


    /**
     * 배열의 크기를 증감시킨다.
     */
    private void resize() {
        int arrayCapacity = array.length;

        // 배열이 비어있는 경우
        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        // 용량이 가득찬 경우
        if (size == arrayCapacity) {
            int newCapacity = arrayCapacity * 2;
            array = Arrays.copyOf(array, newCapacity);
            return;
        }

        // 요량이 절반 미만으로 요소가 차지하고 있는 경우
        if (size < (arrayCapacity / 2)) {
            int newCapacity = arrayCapacity / 2;
            array = Arrays.copyOf(array, Math.max(newCapacity, DEFAULT_CAPACITY));
            return;
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object value) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E value) {

    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    // clone 메소드 구현
}
