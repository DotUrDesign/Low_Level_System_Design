class LRUCache {
public:
    class Node {
    public:
        int key;
        int val;
        Node* prev;
        Node* next;
        Node(int key, int val) {
            this->key = key;
            this->val = val;
        }
    };

    int capacity;
    Node* head = new Node(-1,-1);
    Node* tail = new Node(-1,-1);
    unordered_map<int, Node*> mpp;
    LRUCache(int capacity) {
        this->capacity = capacity;
        mpp.clear();
        head->next = tail;
        head->prev = NULL;
        tail->prev = head;
        tail->next = NULL;
    }

    void deleteNode(Node* node) {
        Node* prevNode = node->prev;
        Node* nextNode = node->next;
        prevNode->next = nextNode;
        nextNode->prev = prevNode;
        mpp.erase(node->key);
    }

    void insertNextToHead(Node* node) {
        Node* nextNode = head->next;
        head->next = node;
        node->prev = head;
        node->next = nextNode;
        nextNode->prev = node;
        mpp[node->key] = node;
    }

    int get(int key) {
        if(mpp.find(key) != mpp.end()) {
            Node* node = mpp[key];
            deleteNode(node);
            insertNextToHead(node);
            return node->val;
        } else {
            return -1;
        }
    }

    void put(int key, int value) {
        if(mpp.find(key) != mpp.end()) {
            Node* node = mpp[key];
            node->val = value;
            mpp[key] = node;
            deleteNode(node);
            insertNextToHead(node);
        } else {
            if(mpp.size() == capacity) {
                Node* node = tail->prev;
                deleteNode(node);
            }
            Node* newNode = new Node(key, value);
            insertNextToHead(newNode);
            mpp[key] = newNode;
        }
    }

};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */