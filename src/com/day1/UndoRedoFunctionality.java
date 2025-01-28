package com.day1;

class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState currentState;
    private int historyLimit;
    private int size;

    public TextEditor(int historyLimit) {
        this.historyLimit = historyLimit;
        this.size = 0;
        this.currentState = new TextState(""); // Initial empty state
    }

    // Add a new text state
    public void addState(String content) {
        TextState newState = new TextState(content);

        if (currentState != null) {
            currentState.next = newState;
            newState.prev = currentState;
        }

        currentState = newState;

        // Maintain history limit
        size++;
        if (size > historyLimit) {
            removeOldestState();
        }
    }

    // Undo functionality
    public void undo() {
        if (currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.content);
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    // Redo functionality
    public void redo() {
        if (currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.content);
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        System.out.println("Current State: " + currentState.content);
    }

    // Remove the oldest state to maintain history limit
    private void removeOldestState() {
        TextState oldest = currentState;

        while (oldest.prev != null) {
            oldest = oldest.prev;
        }

        if (oldest.next != null) {
            oldest.next.prev = null;
            size--;
        }
    }
}

class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("New state");
        editor.displayCurrentState();

        editor.redo(); // Attempt redo when no redo is available
    }
}
