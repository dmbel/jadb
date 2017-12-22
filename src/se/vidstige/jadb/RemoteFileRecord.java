package se.vidstige.jadb;

/**
 * Created by vidstige on 2014-03-19.
 */
class RemoteFileRecord extends RemoteFile {
	public static final RemoteFileRecord DONE = new RemoteFileRecord(null, 0, 0, 0);

	private final int mode;
	private final int size;
	private final long lastModified;
	private String dir;
	private String name;

	public RemoteFileRecord(String name, int mode, int size, long lastModified) {
		this(null, name, mode, size, lastModified);
	}

	public RemoteFileRecord(String dir, String name, int mode, int size, long lastModified) {
		super(name);
		this.mode = mode;
		this.size = size;
		this.lastModified = lastModified;
		this.dir = dir;
		this.name = name;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getPath() {
		return (dir == null) ? name : (dir + (dir.endsWith("/") ? "" : "/") + name);
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public long getLastModified() {
		return lastModified;
	}

	@Override
	public boolean isDirectory() {
		return (mode & (1 << 14)) == (1 << 14);
	}
}
