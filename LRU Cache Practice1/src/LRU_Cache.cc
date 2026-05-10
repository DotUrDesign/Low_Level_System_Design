/*
    head tail
    -1,-1   -1,-1
    get
    put new node
    change the existing node's value
    => delete the node
    => insert next to head

    put new node
    => check the capacity
    if full - delete the LRU node and insert the new node next to head
    if space available - insert the new node next to head

    Node
    int key
    int value
    Node* prev
    Node* next

    unordered_map<int,Node*> => stores the key with the node address
*/


class LRU_Cache {
public:
    class Node{
    public:
        int key;
        int value;
        Node* next;
        Node* value;
        Node(int key, int value) {
            this->key = key;
            this->value = value;
        }
    };

        int capacity;
        Node* head = new Node(-1,-1);
        Node* tail = new Node(-1,-1);
        unordered_map<int,Node*> mpp = new HashMap<>();
        LRU_Cache() {
            capacity = 0;
            mpp.clear();
            head->next = tail;
            tail->prev = head;
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
            if(mpp.find(key) == mpp.end()) {
                return -1;
            }
            Node* node = mpp[key];
            deleteNode(node);
            insertNextToHead(node);
            return node->value;
        }

        void put(int key, int val) {
            if(mpp.find(key) != mpp.end()) {
                Node* node = mpp[key];
                node->value = val;
                deleteNode(node);
                insertNextToHead(node);
            } else {
                if(mpp.size() == capacity) {
                    Node* node = tail->prev;
                    deleteNode(node);
                    Node* newNode = new Node(key, val);
                    insertNextToHead(newNode);
                }
                Node* newNode = new Node(key, val);
                insertNextToHead(newNode);
            }
        }
}