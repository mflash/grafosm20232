CPPFLAGS = -Wall -g -std=c++11   # Opções do compilador: todos warnings e debug info

# classe Graph
appgraph = appgraph
appgraph_src = appgraph.cpp graph.cpp
appgraph_obj = $(appgraph_src:.cpp=.o)

# classe Digraph
appdgraph = appdigraph
appdgraph_src = appdigraph.cpp digraph.cpp graph.cpp
appdgraph_obj = $(appdgraph_src:.cpp=.o)

# DFS
appdfs = appdfs
appdfs_src = appdfs.cpp graph.cpp depthfirstsearch.cpp
appdfs_obj = $(appdfs_src:.cpp=.o)

# BFS
appbfs = appbfs
appbfs_src = appbfs.cpp graph.cpp breadthfirstsearch.cpp
appbfs_obj = $(appbfs_src:.cpp=.o)

# Ciclos nao dirigidos
appucycle = appucycle
appucycle_src = appundirectedcycle.cpp undirectedcycle.cpp graph.cpp
appucycle_obj = $(appucycle_src:.cpp=.o)

all: appgraph appdigraph appdfs appbfs appucycle

$(appgraph): $(appgraph_obj)
	g++ $(CPPFLAGS) $(appgraph_obj) -o $@

$(appdgraph): $(appdgraph_obj)
	g++ $(CPPFLAGS) $(appdgraph_obj) -o $@

$(appdfs): $(appdfs_obj)
	g++ $(CPPFLAGS) $(appdfs_obj) -o $@

$(appbfs): $(appbfs_obj)
	g++ $(CPPFLAGS) $(appbfs_obj) -o $@

$(appucycle): $(appucycle_obj)
	g++ $(CPPFLAGS) $(appucycle_obj) -o $@

$(appdcycle): $(appdcycle_obj)
	g++ $(CPPFLAGS) $(appdcycle_obj) -o $@

clean:
	-@ rm -f $(appgraph_obj) $(appgraph) $(appdgraph_obj) $(appdgraph) $(appdfs_obj) $(appbfs_obj) $(appdfs) $(appbfs) $(appucycle) $(appucycle_obj) $(appdcycle) $(appdcycle_obj)
