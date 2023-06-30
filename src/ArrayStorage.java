/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int emptyPosition = 0;

    /**
     * @return index of the index of resume with given uuid
     * if not found returns -1
     */
    private int find(String uuid) {
        if (this.storage[0] == null)
            return -1;
        for (int i = 0; i < this.emptyPosition; i++)
            if (this.storage[i].uuid.equals(uuid))
                return i;
        return -1;

    }

    void clear() {
        for (int i = 0; i <= this.emptyPosition; i++)
            this.storage[i] = null;
        this.emptyPosition = 0;
    }

    void save(Resume r) {
        this.storage[emptyPosition] = r;
        this.emptyPosition++;
    }

    Resume get(String uuid) {
        int i = this.find(uuid);
        return (i >= 0) ? storage[i] : null;
    }

    void delete(String uuid) {
        int i = this.find(uuid);
        if (i < 0)
            return;
        // TODO: fix the case when find == lastIndex
        for (int j = i; j < this.emptyPosition; j++) {
            this.storage[j] = this.storage[j + 1];
        }
        this.emptyPosition--;
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (this.emptyPosition == 0)
            return new Resume[0];
        Resume[] result = new Resume[emptyPosition];
        System.arraycopy(this.storage, 0, result, 0, this.emptyPosition);
        return result;
    }

    int size() {

        return 0;
    }
}
