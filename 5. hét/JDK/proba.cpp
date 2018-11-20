#include <iostream>
#include <vector>
#include <boost/filesystem.hpp>

namespace fs = boost::filesystem;
	
int main(int ac, char** av) {
		std::string path;
		std::vector<std::string> namelist;
		
        fs::path p("/home/liliane/Asztal/openjdk/jdk/src");
        fs::recursive_directory_iterator begin(p), end;
        std::vector<fs::directory_entry> v(begin, end);

        for (auto &f : v) {
			path = f.path().string();
			if (path.find(".java") != std::string::npos) {
				std::string extractfile = path.substr(path.find_last_of("/")+1, path.find_last_of(".")-path.find_last_of("/")-1);
				namelist.push_back(extractfile);
			}
		}
		
		std::sort(namelist.begin(), namelist.end());
		
		for (auto &i : namelist)
			std::cout << i << std::endl;
    }