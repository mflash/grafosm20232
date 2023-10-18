#include "depthfirstsearch.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <set>

using namespace std;

DepthFirstSearch::DepthFirstSearch(Graph g, string s)
{
	this->s = s;
	dfs(g, s);
}

void DepthFirstSearch::dfs(Graph g, string s)
{
}

bool DepthFirstSearch::hasPathTo(string s)
{
}

vector<string> DepthFirstSearch::pathTo(string s)
{
	vector<string> path;
	// ...
	return path;
}
