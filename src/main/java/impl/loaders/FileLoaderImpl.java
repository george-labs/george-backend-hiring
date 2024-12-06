package impl.loaders;

import api.loaders.FileLoader;
import impl.writers.utils.ReadFileUtil;
import java.util.List;

public class FileLoaderImpl implements FileLoader {

    @Override
    public List<String> loadFile() {
        return ReadFileUtil.readFile();
    }

    @Override
    public List<String> loadFile(final String filePath) {
        return ReadFileUtil.readFile(filePath);
    }

}