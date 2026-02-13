# 🚀 Jenkins Remoting via Message Bus (RabbitMQ)

A distributed DevOps project that enhances controller–agent communication using message-oriented middleware. This project simulates an improved remoting architecture inspired by **Jenkins**, where build jobs are sent asynchronously through **RabbitMQ** instead of direct TCP connections.

The system demonstrates scalable, decoupled, and fault-tolerant communication suitable for modern CI/CD environments.

---

## 📌 Project Overview

Traditional Jenkins remoting relies on direct controller-agent communication. This project introduces a message broker layer to enable:

* Asynchronous job execution
* Decoupled controller-agent architecture
* Improved scalability and fault tolerance
* Distributed build processing

Architecture:

```
Controller → RabbitMQ → Agent
```

---

## 🧱 Project Structure

```
jenkins-remoting-bus/
│
├── common/        # Shared message models
├── controller/    # Sends build jobs
├── agent/         # Executes jobs
├── docker-compose.yml
└── pom.xml
```

---

## ⚙️ Tech Stack

* Java 11+
* Maven (multi-module project)
* **Docker**
* RabbitMQ (message broker)
* Distributed systems architecture

---

## 🚀 How to Run

### ✅ Step 1: Clone the Repository

```bash
git clone <your-repo-url>
cd jenkins-remoting-bus
```

---

### ✅ Step 2: Install Prerequisites

Ensure these are installed:

* Java 11+
* Maven
* Docker

Verify:

```bash
java -version
mvn -version
docker --version
```

---

### ✅ Step 3: Start RabbitMQ

```bash
docker-compose up -d
```

Open dashboard:

```
http://localhost:15672
```

Login:

```
guest / guest
```

---

### ✅ Step 4: Build the Project

From the root folder:

```bash
mvn clean install
```

---

### ✅ Step 5: Start the Agent

Open Terminal 1:

```bash
cd agent
mvn exec:java
```

Expected output:

```
Agent waiting for jobs...
```

---

### ✅ Step 6: Run the Controller

Open Terminal 2:

```bash
cd controller
mvn exec:java
```

Expected output:

```
Sent job: TestJob
```

---

### ✅ Step 7: Verify Execution

Agent terminal should show:

```
Executing job: TestJob
Job completed
```

---

## 🧠 How It Works

1. Controller sends a build command as a message
2. RabbitMQ queues the message
3. Agent consumes the message
4. Agent executes the command
5. Execution result is printed

This simulates a scalable CI/CD remoting system.

---

## ✨ Features

* Multi-module Maven architecture
* Message-based controller-agent communication
* Asynchronous job processing
* Dockerized message broker
* Simple distributed execution model

---

## 🔮 Future Enhancements

* Bidirectional status reporting
* Real-time log streaming
* JSON message serialization
* Kubernetes deployment
* Jenkins plugin integration

---

## 🎯 Learning Outcomes

This project demonstrates:

* Distributed system design
* Message queue integration
* Multi-module Maven setup
* Java networking concepts
* DevOps architecture principles

---

## 📄 License

This project is open-source and available under the MIT License.

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Open a pull request

---

## 👨‍💻 Author

Developed as a DevOps learning project focused on distributed CI/CD architecture.

---

⭐ If you find this project useful, consider giving it a star!
