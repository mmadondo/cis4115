# cis4115
CIS 4115 Artificial Intelligence with Robotics Spring 2018

## Unit 9 - Convolutional Neural Networks

A CNN consists of an input and an output layer, as well as multiple hidden layers. The hidden layers of a CNN typically consist of convolutional layers, pooling layers, fully connected layers and normalization layers

### Activation Functions (AF)
- Introduce non-linearity into the output of the neuron. Every AF takes a single number and performs a mathematical operation on it.
- Examples of AV:
> **Sigmoid**: takes takes a real-valued input and squashes it to range between 0 and 1:
  s(x) = 1 / (1 + exp(-x))

> **tanh**: takes a real-valued input and squashes it to the range [-1, 1]
  tanh(x) = 2s(2x) - 1

> **ReLU**: ReLU stands for Rectified Linear Unit. It takes a real-valued input and thresholds it at zero (replaces negative values with zero)
f(x) = max(0, x)

### Feedforward Neural Network
It contains multiple neurons (nodes) arranged in layers. Nodes from adjacent layers have connections or edges between them. All these connections have weights associated with them.
It can consist of three types of nodes:
* **Input Nodes** – The Input nodes provide information from the outside world to the network and are together referred to as the “Input Layer”. No computation is performed in any of the Input nodes – they just pass on the information to the hidden nodes.
* **Hidden Nodes** – The Hidden nodes have no direct connection with the outside world (hence the name “hidden”). They perform computations and transfer information from the input nodes to the output nodes. A collection of hidden nodes forms a “Hidden Layer”. While a feedforward network will only have a single input layer and a single output layer, it can have zero or multiple Hidden Layers.
* **Output Nodes** – The Output nodes are collectively referred to as the “Output Layer” and are responsible for computations and transferring information from the network to the outside world.

_N.B. In Feedforward NN information only moves forward, unlike in RNN neural networks where the connections between the nodes form a cycle._

Two examples of FNNs are Single Layer Perceptron (no hidden layers) and Multi Layer Perceptron (one or more hidden layers).

#### Multi Layer Perceptron (MLP)
It contains one or more hidden layers (apart from one input and one output layer).  While a single layer perceptron can only learn linear functions, a multi layer perceptron can also learn non – linear functions.

![](https://github.com/rasbt/python-machine-learning-book/blob/master/faq/difference-deep-and-normal-learning/mlp.png)

where y_hat is the final class label that we return as the prediction based on the inputs (x) if this are classification tasks. The "a"s are our activated neurons and the "w"s are the weight coefficients.

### Terms
Deep neural network is simply a feedforward network with many hidden layers.
Convolutional layers apply a convolution operation to the input, passing the result to the next layer.
Pooling - CNN may include local or global pooling layers which combine the outputs of neuron clusters at one layer into a single neuron in the next layer.
Fully connected layers connect every neuron in one layer to every neuron in another layer.

Typical CNN Architecture:
![](https://en.wikipedia.org/wiki/Convolutional_neural_network#/media/File:Typical_cnn.png)
* **References**
1. https://ujjwalkarn.me/2016/08/09/quick-intro-neural-networks/