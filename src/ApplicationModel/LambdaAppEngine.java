package ApplicationModel;

import LambdaAppUI.Observer;

public interface LambdaAppEngine {

    // used the Observer interface here rather than just LambdaView because in
    // some cases controllers might also need to be updated (i.e. a change to
    // the model might require a controller to no longer handle some events)
    void addObservers(Observer observer);

    //Shouldn't throw an error if not a valid observer
    void removeObservers(Observer observer);

    void notifyObservers();
}
