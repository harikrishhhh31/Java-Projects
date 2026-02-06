# Java Backend Journey

This repository marks the start of my backend learning journey.

I began by building a basic HTTP server in Java (no frameworks) to understand how ports, HTTP requests, responses, and handlers actually work.

I’ll be updating this repository consistently as I learn and improve step by step.

Focus: fundamentals first, frameworks later.

## Day 2 – Understanding Routing & Request Inspection

Today I focused on understanding how backend routing and request handling actually work in Java.

What I built:
- Added a second endpoint (`/info`) using `createContext`
- Understood that each context maps a URL path to a handler
- Learned how a backend inspects client requests using `HttpExchange`

Key concepts I learned:
- Difference between defining an endpoint and handling a request
- How to read request data:
  - HTTP method
  - Request path
  - Request headers
- How request and response share the same `HttpExchange`
- Correct HTTP lifecycle:
  read request → build response → send headers → write body → close

Challenges:
- Java syntax (imports, string concatenation, collections)
- Iterating over headers using `keySet()` and for-each loops

Outcome:
- Built a request inspector endpoint that displays real client request details
- Gained clarity on backend fundamentals beyond frameworks
