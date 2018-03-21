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
 - contains multiple neurons (nodes) arranged in layers. Nodes from adjacent layers have connections or edges between them. All these connections have weights associated with them.
 - it can consist of three types of nodes:
* **Input Nodes** – The Input nodes provide information from the outside world to the network and are together referred to as the “Input Layer”. No computation is performed in any of the Input nodes – they just pass on the information to the hidden nodes.
* **Hidden Nodes** – The Hidden nodes have no direct connection with the outside world (hence the name “hidden”). They perform computations and transfer information from the input nodes to the output nodes. A collection of hidden nodes forms a “Hidden Layer”. While a feedforward network will only have a single input layer and a single output layer, it can have zero or multiple Hidden Layers.
* **Output Nodes** – The Output nodes are collectively referred to as the “Output Layer” and are responsible for computations and transferring information from the network to the outside world.

_N.B. In Feedforward NN information only moves forward, unlike in RNN neural networks where the connections between the nodes form a cycle._